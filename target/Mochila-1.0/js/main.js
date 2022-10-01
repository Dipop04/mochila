var username = new URL(location.href).searchParams.get("username");
var user;

$(document).ready(function () {

    $(function () {
        $('[data-toggle="tooltip"]').tooltip();
    });

    getUsuario().then(function () {
        
        $("#mi-perfil-btn").attr("href","profile.html?username=" + username);
        
        getNegocio(false, "ASC");

        $("#ordenar-servicio").click(ordenarNegocio);
    });
});


async function getUsuario() {

    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioPedir",
        data: $.param({
            username: username
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                user = parsedResult;
            } else {
                console.log("Error recuperando los datos del usuario");
            }
        }
    });

}

function getNegocio(ordenar, orden) {

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletNegocioListar",
        data: $.param({
            ordenar: ordenar,
            orden: orden
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                mostrarNegocios(parsedResult);
            } else {
                console.log("Error recuperando los datos de los negocios");
            }
        }
    });
}

function mostrarNegocios(negocio) {

    let contenido = "";

    $.each(negocio, function (index, negocio) {

        negocio = JSON.parse(negocio);
        
            contenido += '<tr><th scope="row">' + negocio.id + '</th>' +
                    '<td>' + negocio.servicio + '</td>' +
                    '<td>' + negocio.nombre_negocio + '</td>' +
                    '<td><img src="' + negocio.imagen + '" class="card-img-top"></td>' +
                    '<td>' + negocio.direccion + '</td>' +
                    '<td>' + negocio.zona + '</td>' +
                    '<td>' + negocio.precio_minimo + '</td>' +
                    '<td>' + negocio.precio_maximo + '</td>' +
                    '<td>' + negocio.hora_abierto + '</td>' +
                    '<td>' + negocio.hora_cierre + '</td>' +
                    '<td>' + negocio.dias + '</td>' +
                    '<td>' + negocio.ubicacion + '</td>' +
                    //'<td><iframe style="border:0; width: 100%; height: 100%;" src="' + negocio.ubicacion + '" frameborder="0" allowfullscreen></iframe></td>' +
                    '<td><a href=">' + negocio.url + '">Página web</a></td>' +
                    //'<td>' + negocio.url + '</td>' +
                    '<td>' + negocio.descripcion + '</td>'+
                    '<td><button onclick="itinerarioNegocio(' + negocio.id + ');" class="btn btn-success" >Reservar</button></td></tr>';
    });
    $("#negocio-tbody").html(contenido);
}


function ordenarNegocio() {

    if ($("#icono-ordenar").hasClass("fa-sort")) {
        getNegocio(true, "ASC");
        $("#icono-ordenar").removeClass("fa-sort");
        $("#icono-ordenar").addClass("fa-sort-down");
    } else if ($("#icono-ordenar").hasClass("fa-sort-down")) {
        getNegocio(true, "DESC");
        $("#icono-ordenar").removeClass("fa-sort-down");
        $("#icono-ordenar").addClass("fa-sort-up");
    } else if ($("#icono-ordenar").hasClass("fa-sort-up")) {
        getNegocio(false, "ASC");
        $("#icono-ordenar").removeClass("fa-sort-up");
        $("#icono-ordenar").addClass("fa-sort");
    }
}


function itinerarioNegocio(id) { 

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletNegocioItinerario",
        data: $.param({
            id: id,
            username: username

        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                location.reload();
            } else {
                console.log("Error en la reserva del negocio");
            }
        }
    });
}
