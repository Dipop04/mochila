var username = new URL(location.href).searchParams.get("username");
var user;




$(document).ready(function () {


    getUsuario().then(function () {
        $("#inicio-lnk").attr("href", `inicio.html?username=${username}`);
        $("#alInicio-lnk").attr("href", `inicio.html?username=${username}`);
        $("#negocios-lnk").attr("href", `negocios.html?username=${username}`);
        $("#negocio-btn").attr("href", `negocios.html?username=${username}`);
        $("#itinerario-lnk").attr("href", `itinerario.html?username=${username}`);
        $("#equipo-lnk").attr("href", `equipo.html?username=${username}`);
        $("#contacto-lnk").attr("href", `contacto.html?username=${username}`);
        $('#mi-perfil-btn').attr('href', 'actualizarperfil.html?username=' + username);

        getNegocio(false, 'ASC');

        $('#ordenar-servicio').click(ordenarNegocio);
    });

    fillUsuario().then(function () {

        getItinerario(user.username);


    });

    $("#reservar-btn").attr("href", `negocios.html?username=${username}`);

    $("#form-modificar").on("submit", function (event) {

        event.preventDefault();
        modificarUsuario();
    });

    $("#aceptar-eliminar-cuenta-btn").click(function () {

        eliminarCuenta().then(function () {
            location.href = "index.html";
        })
    })

});

async function getUsuario() {
    await $.ajax({
        type: 'GET',
        dataType: 'html',
        url: './ServletUsuarioPedir',
        data: $.param({
            username: username,
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                user = parsedResult;
                console.log('nombre???', user.nombre)
                $('#Saludando').html(user.nombre);
            } else {
                console.log('Error recuperando los datos del usuario');
            }
        },
    });
}


async function fillUsuario() {
    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioPedir",
        data: $.param({
            username: username,
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                user = parsedResult;

                $("#input-username").val(parsedResult.username);
                $("#input-contrasena").val(parsedResult.contrasena);
                $("#input-cedula").val(parsedResult.cedula);
                $("#input-nombre").val(parsedResult.nombre);
                $("#input-apellidos").val(parsedResult.apellidos);
                $("#input-email").val(parsedResult.email);
                $("#input-rol").prop("checked", parsedResult.rol);

            } else {
                console.log("Error recuperando los datos del usuario");
            }
        }
    });
}

function getItinerario(username) {


    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletItinerarioListar",
        data: $.param({
            username: username,
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {

                mostrarHistorial2(parsedResult)

            } else {
                console.log("Error recuperando los datos del itinerario");
            }
        }
    });
}


let contenido = '';
const mostrarHistorial2 = (negocios) => {
    negocios.map((negocio, idx) => {
        negocio = JSON.parse(negocio);

        contenido += `<div class="course-item col-4" id="negocio-item">
        <img src="${negocio.imagen}" class=" img-tarjeta img-fluid" alt="...">
        <div class="course-content">
            <div class="d-flex justify-content-between align-items-center mb-3">
                <h4>${negocio.servicio}</h4>
                <p class="price">$${negocio.precio_minimo}</p>
            </div>

            <h3><a href="${negocio.url}">${negocio.nombre_negocio}</a></h3>
            <p>${negocio.descripcion}</p>
            <div>
            <ul>
                <li>${negocio.direccion}</li>
                <li>${negocio.zona}</li>
                <li>${negocio.precio_maximo}</li>
                <li>${negocio.hora_abierto}</li>
                <li>${negocio.hora_cierre}</li>
                <li>${negocio.dias}</li>
                <li><a href="${negocio.ubicacion}">Ubicación</a></li>
            </ul>
            </div>
            <button id="devolver-btn" onclick="retirarNegocio(${negocio.id});" class="btn btn-danger" >Cancelar reserva</button>
        </div>
    </div>`;
        $('#contenedorItinerario').html(contenido);
        console.log('index Arr', idx + 1);
    });
};






function mostrarHistorial(negocio) {
    let contenido = "";
    if (negocio.length >= 1) {
        $.each(negocio, function (index, negocio) {
            negocio = JSON.parse(negocio);

            contenido += '<tr><th scope="row">' + negocio.id + '</th>' +
                    '<td>' + negocio.nombre_negocio + '</td>' +
                    '<td>' + negocio.fecha_inicio + '</td>' +
                    '<td>' + negocio.servicio + '</td>' +
                    '<td><button id="devolver-btn" onclick= "retirarNegocio(' + negocio.id
                    + ');" class="btn btn-danger">Retirar negocio</button></td></tr>';

        });
        $("#historial-tbody").html(contenido);
        $("#historial-table").removeClass("d-none");
        $("#historial-vacio").addClass("d-none");

    } else {
        $("#historial-vacio").removeClass("d-none");
        $("#historial-table").addClass("d-none");
    }
}


function retirarNegocio(id) {

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletNegocioRetirar",
        data: $.param({
            id: id,
            username: username,
        }),
        success: function (result) {

            if (result != false) {

                location.reload();

            } else {
                console.log("Error retirando el negocio");
            }
        }
    });

}

function modificarUsuario() {

    let username = $("#input-username").val();
    let contrasena = $("#input-contrasena").val();
    let cedula = $("#input-cedula").val();
    let nombre = $("#input-nombre").val();
    let apellidos = $("#input-apellidos").val();
    let email = $("#input-email").val();
    let rol = $("#input-rol").prop('checked');
    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioModificar",
        data: $.param({
            username: username,
            contrasena: contrasena,
            cedula: cedula,
            nombre: nombre,
            apellidos: apellidos,
            email: email,
            rol: rol,
        }),
        success: function (result) {

            if (result != false) {
                $("#modificar-error").addClass("d-none");
                $("#modificar-exito").removeClass("d-none");
            } else {
                $("#modificar-error").removeClass("d-none");
                $("#modificar-exito").addClass("d-none");
            }

            setTimeout(function () {
                location.reload();
            }, 3000);

        }
    });

}

async function eliminarCuenta() {

    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioEliminar",
        data: $.param({
            username: username
        }),
        success: function (result) {

            if (result != false) {

                console.log("Usuario eliminado")

            } else {
                console.log("Error eliminando el usuario");
            }
        }
    });
}