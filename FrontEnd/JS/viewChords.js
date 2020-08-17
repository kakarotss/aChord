
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
// console.log(getParams(window.location.href).courseId);

function getAll() {
    courseId = getParams(window.location.href).courseId;
    userId = sessionStorage.getItem("LoggedInId");


    fetch(`http://localhost:9001/aChord/courseChords?Uid=${userId}`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
        "courseId": courseId,
    })
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
                        let string = '<div class="alert alert-warning" <h2><b>Course Unavailable: you may have added this course to your profile <a href="myProfile.js">click here</a><b></b></h2><div></div>';
                        document.getElementById("textArea").innerHTML += string;
                    }
                    else {
                        document.getElementById("button").innerHTML += '<button onclick="courseLine(userId, courseId)" class="btn btn-block btn-danger">Add to Profile</button><hr>';
                        document.getElementById("chords").innerHTML="";
                        for (let i = 0; i < data.length; i++) {

                                let string = '<div class="alert alert-dark"><center><H2>'+data[i].chordTitle+'</H2></center><img src="chordImg/'+data[i].chordImg+'" id="image"><hr><h5>'+data[i].chordDescription+'</h5></div><hr>';
                                document.getElementById("chords").innerHTML += string;

                        }
                    }
                });
            })
}


function courseLine(userId, courseId) {

    fetch(`http://localhost:9001/aChord/addLine`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            userId: userId,
            courseId: courseId

        })
    })
        .then(
            function(response) {
                if (response.status !== 200) {
                    console.log('Looks like there was a problem. Status Code: ' +
                        response.status);
                    return;
                }
                else {
                    document.getElementById("button").innerHTML = '';

                    document.getElementById("button").innerHTML += '<a disabled class=" disabled btn btn-block btn-success">Added Successfully, you can view your courses in your profile</a><hr>';

                    // setTimeout(function(){ window.location.href = "allCourses.html"; }, 1500);
                    // getAll();



                }


            })
}

