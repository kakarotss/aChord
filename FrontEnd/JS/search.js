
$(function() {
   getAll();
});



var getParams = function (url) {
    var params = {};
    var parser = document.createElement('a');
    parser.href = url;
    var query = parser.search.substring(1);
    var vars = query.split('&');
    for (var i = 0; i < vars.length; i++) {
        var pair = vars[i].split('=');
        params[pair[0]] = decodeURIComponent(pair[1]);
    }
    return params;
};
// getParams(window.location.href).courseId;

function getAll() {
    search = getParams(window.location.href).search;

    fetch(`http://localhost:9003/aChord/search?search=${search}`, {
        method: "GET",
        headers: {
            "Content-Type": "application/json"
        },

    })
        .then(
            function(response) {
                if (response.status !== 200) {
                    console.log('Looks like there was a problem. Status Code: ' +
                        response.status);
                    return;
                }
                response.json().then(function(data) {


                    if(data.length<=0){
                        let string = '<div class="alert alert-warning" <h2><b>No Results Found :(<b></b></h2><div></div>';
                        document.getElementById("textArea").innerHTML += string;
                    }
                    else {
                        for (let i = 0; i < data.length; i++) {

                            console.log("safasfasfasfasfasfasafasf");

                                let string = '<div class="alert alert-dark"><center><H2>'+data[i].chordTitle+'</H2></center><img src="chordImg/'+data[i].chordImg+'" id="image"><hr><h5>'+data[i].chordDescription+'</h5></div><hr>';
                                document.getElementById("chords").innerHTML += string;

                        }
                    }
                });
            })
}




