function onclick_radio_entidad() {
    document.getElementById("form-persona-nombre").style.display = "none";
    document.getElementById("div-select-persona").style.display = "none";
    document.getElementById("form-persona").style.display = "none";
    document.getElementById("form-entidad-nombre").style.display = "block";
    document.getElementById("div-select-entidad").style.display = "block";
    document.getElementById("form-entidad").style.display = "block";
}

function onclick_radio_usuario() {
    document.getElementById("form-persona-nombre").style.display = "block";
    document.getElementById("div-select-persona").style.display = "block";
    document.getElementById("form-persona").style.display = "block";
    document.getElementById("form-entidad-nombre").style.display = "none";
    document.getElementById("div-select-entidad").style.display = "none";
    document.getElementById("form-entidad").style.display = "none";
}

function loadEntidadesPorNombre(value) {
    var xhttp = new XMLHttpRequest();
    
    xhttp.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200) {
            document.getElementById("select-entidades").innerHTML = this.responseText;
        }
    };
    
    xhttp.open("GET", "GetEntidadesPorNombre?nb_entidad=" + value, true);
    xhttp.send();
}

function loadEntidad(value) {
    var xhttp = new XMLHttpRequest();
    
    xhttp.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200) {
            document.getElementById("form-entidad").innerHTML = this.responseText;
        }
    };
    
    xhttp.open("GET", "GetEntidadPorId?id_entidad=" + value, true);
    xhttp.send();
}

function loadPersonasPorNombre(value) {
    var xhttp = new XMLHttpRequest();
    
    xhttp.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200) {
            document.getElementById("select-personas").innerHTML = this.responseText;
        }
    };
    
    xhttp.open("GET", "GetPersonasPorNombre?nb_persona=" + value, true);
    xhttp.send();
}

function loadPersona(value) {
    var xhttp = new XMLHttpRequest();
    
    xhttp.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200) {
            document.getElementById("form-persona").innerHTML = this.responseText;
        }
    };
    
    xhttp.open("GET", "GetPersonaPorId?id_persona=" + value, true);
    xhttp.send();
}
