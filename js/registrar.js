function onclick_radio_entidad() {
    document.getElementById("form-usuario").style.display = "none";
    document.getElementById("usuario-title").style.display = "none";
    document.getElementById("form-entidad").style.display = "block";
    document.getElementById("entidad-title").style.display = "block";
}

function onclick_radio_usuario() {
    document.getElementById("form-entidad").style.display = "none";
    document.getElementById("entidad-title").style.display = "none";
    document.getElementById("form-usuario").style.display = "block";
    document.getElementById("usuario-title").style.display = "block";
}

function loadEntidades() {
    var xhttp = new XMLHttpRequest();
    
    xhttp.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200) {
            document.getElementById("select-entidades").innerHTML = this.responseText;
        }
    };
    
    xhttp.open("GET", "GetEntidades", true);
    xhttp.send();
}
