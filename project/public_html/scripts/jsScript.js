function add(page){
    var element = document.getElementById('content-top');
    element.innerHTML="<h1>Add "+page+"</h1>";
    var xhttp = new XMLHttpRequest();
    xhttp.open("GET", "scripts/add.php?fn=" + page, true);
    xhttp.send();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            var element = document.getElementById('content-bottom');
            element.innerHTML = this.responseText;
        }
    };
}
function submit(page){
    var element = document.getElementById('addForm');
    var valuesArray = element.elements;
    var len = valuesArray.length;
    var data = "";
    for(var i = 0; i < len - 2; i++){ //-2 is for submit and cancel button
        // console.log(valuesArray[i].name + " = " + valuesArray[i].value);
        data += "&" + valuesArray[i].name + "=" + valuesArray[i].value
    }
    var xhttp = new XMLHttpRequest();
    xhttp.open("GET", "scripts/submit.php?fn=" + page + data + yearSeason(), true);
    xhttp.send();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            var element = document.getElementById('content-bottom');
            element.innerHTML = this.responseText;
            // console.log(this.responseText);
        }
    };
}

function load(page){
    var element = document.getElementById('content-top');
    element.innerHTML="<h1>"+page+"</h1>";
    var xhttp = new XMLHttpRequest();
    var yearEl = document.getElementById('year');
    var seasonEl = document.getElementById('season');
    var year = document.getElementById('year').options[yearEl.selectedIndex].value;
    var season = document.getElementById('season').options[seasonEl.selectedIndex].value;
    xhttp.open("GET", "scripts/load.php?fn=" + page + "&yr=" + year + "&sn=" + season, true);
    xhttp.send();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            var element = document.getElementById('content-bottom');
            element.innerHTML = this.responseText;
        }
    };
}

function yearSeason(){
    var yearEl = document.getElementById('year');
    var seasonEl = document.getElementById('season');
    var year = document.getElementById('year').options[yearEl.selectedIndex].value;
    var season = document.getElementById('season').options[seasonEl.selectedIndex].value;
    return "&yr=" + year + "&sn=" + season;
}