var username = new URL(location.href).searchParams.get('username');
var user;

$(document).ready(function () {
    // const nombreUsuario = ${user.nombre}
    $(function () {
        $('[data-toggle="tooltip"]').tooltip();
    });

    getUsuario().then(function () {
        $("#inicio-lnk").attr("href", `inicio.html?username=${username}`);
        $("#alInicio-lnk").attr("href", `inicio.html?username=${username}`);
        $("#negocios-lnk").attr("href", `negocios.html?username=${username}`);
        $("#negocio-btn").attr("href", `negocios.html?username=${username}`);
        $(".ir-negocios").attr("href", `negocios.html?username=${username}`);
        $("#itinerario-lnk").attr("href", `itinerario.html?username=${username}`);
        $("#equipo-lnk").attr("href", `equipo.html?username=${username}`);
        $("#contacto-lnk").attr("href", `contacto.html?username=${username}`);
        $('#mi-perfil-btn').attr('href', 'actualizarperfil.html?username=' + username);

        getNegocio(false, 'ASC');

        $('#ordenar-servicio').click(ordenarNegocio);
    });
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
                $('#Saludando').html(user.nombre);
                $('.userNombre').html(user.nombre);
            } else {
                console.log('Error recuperando los datos del usuario');
            }
        },
    });
}
// debugger;
function getNegocio(ordenar, orden) {
    $.ajax({
        type: 'GET',
        dataType: 'html',
        url: './ServletNegocioListar',
        data: $.param({
            ordenar: ordenar,
            orden: orden,
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                mostrarNegocios(parsedResult);
            } else {
                contenido = `<h1>Lo sentimos. En este momento no hay negocios disponibles.</h1>`
                $('#contenedorNegocios').html(contenido);
                console.log('Error recuperando los datos de los negocios');
            }
        },
    });
}
let contenido = '';
const mostrarNegocios = (negocios) => {
    negocios.map((negocio, idx) => {
        negocio = JSON.parse(negocio);

        contenido += `<div class="course-item col-4" id="negocio-item">
        <img src="${negocio.imagen}" class=" img-tarjeta img-fluid" alt="...">
        <div class="course-content">
            <div class="d-flex justify-content-between align-items-center mb-3">
                <h4 class="badge rounded-pill bg-info">${negocio.servicio}</h4>
                <p class="price">$${negocio.precio_minimo}</p>
            </div>

            <h3><a href="${negocio.url}" target="_blank">${negocio.nombre_negocio}</a></h3>
            <p>${negocio.descripcion}</p>
            <div>
            <ul>
                <li>Dirección: ${negocio.direccion}</li>
                <li>Zona: ${negocio.zona}</li>
                <li>Días de apertura: ${negocio.dias}</li>
                <li>Horario de atención: ${negocio.hora_abierto} - ${negocio.hora_cierre}</li>
                <li>Rango de precios: $${negocio.precio_maximo} - $${negocio.precio_minimo}</li>
                <li><a href="${negocio.ubicacion}" target="_blank">Ubicación</a></li>
            </ul>
            </div>
            <button onclick="itinerarioNegocio(${negocio.id});" class="btn btn-success" >Reservar</button>
        </div>
    </div>`;
        $('#contenedorNegocios').html(contenido);
    });
};

function ordenarNegocio() {
    if ($('#icono-ordenar').hasClass('fa-sort')) {
        getNegocio(true, 'ASC');
        $('#icono-ordenar').removeClass('fa-sort');
        $('#icono-ordenar').addClass('fa-sort-down');
    } else if ($('#icono-ordenar').hasClass('fa-sort-down')) {
        getNegocio(true, 'DESC');
        $('#icono-ordenar').removeClass('fa-sort-down');
        $('#icono-ordenar').addClass('fa-sort-up');
    } else if ($('#icono-ordenar').hasClass('fa-sort-up')) {
        getNegocio(false, 'ASC');
        $('#icono-ordenar').removeClass('fa-sort-up');
        $('#icono-ordenar').addClass('fa-sort');
    }
}

function itinerarioNegocio(id) {
    $.ajax({
        type: 'GET',
        dataType: 'html',
        url: './ServletNegocioItinerario',
        data: $.param({
            id: id,
            username: username,
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                location.reload();
            } else {
                console.log('Error en la reserva del negocio');
            }
        },
    });
}
