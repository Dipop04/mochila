var username = new URL(location.href).searchParams.get("username");
var user;

$(document).ready(function () {


    fillUsuario().then(function () {

        getItinerario(user.username);
    });

    $("#reservar-btn").attr("href", `home.html?username=${username}`);

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

                mostrarHistorial(parsedResult)

            } else {
                console.log("Error recuperando los datos del itinerario");
            }
        }
    });
}

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
            username: username,
            id: id,
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