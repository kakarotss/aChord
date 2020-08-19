
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
    courseLineId = getParams(window.location.href).courseLineId;
    courseStatus = getParams(window.location.href).status;
    userId = sessionStorage.getItem("LoggedInId");

    let url;

        url = `http://localhost:9003/aChord/courseChordsOffline`;




    fetch(url, {
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



                        if(userId != null && courseStatus != "Done") {
                            document.getElementById("button").innerHTML += '<button onclick="courseFinish(courseLineId, userId, courseId)" class="btn btn-block btn-success">Finish</button><hr>';
                            document.getElementById("chords").innerHTML = "";
                        }
                        else {
                            document.getElementById("button").innerHTML = '';

                            document.getElementById("button").innerHTML += '<a disabled class=" disabled btn btn-block btn-success">Congratulations! You have completed this course</a><hr>';


                        }
                        for (let i = 0; i < data.length; i++) {

                                let string = '<div class="alert alert-dark"><center><H2>'+data[i].chordTitle+'</H2></center><img src="chordImg/'+data[i].chordImg+'" id="image"><hr><h5>'+data[i].chordDescription+'</h5></div><hr>';
                                document.getElementById("chords").innerHTML += string;

                        }

                });
            })
}



function courseFinish(courseLineId, userId, courseId) {

    fetch(`http://localhost:9003/aChord/addLine`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            userId: userId,
            courseId: courseId,
            courseLineId: courseLineId,
            courseStatus: "Done"

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
                    updateLevel();
                    document.getElementById("button").innerHTML = '';

                    document.getElementById("button").innerHTML += '<a disabled class=" disabled btn btn-block btn-success">Congratulations! You have completed this course</a><hr>';

                    // setTimeout(function(){ window.location.href = "allCourses.html"; }, 1500);
                    // getAll();



                }


            })
}


function updateLevel() {

    fetch('http://localhost:9003/aChord/myProfile', {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },

        body: JSON.stringify({
            "username": sessionStorage.getItem("LoggedInUsername"),
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
                    // console.log("asda" +sessionStorage.getItem("loggedInUsername"));
                    console.log(data);


                    if(data.length !=0){

                        userLevel = parseInt(getParams(window.location.href).userLevel);
                        userLevel +=1;

                        fetch(`http://localhost:9003/aChord/Register`, {
                            method: "POST",
                            headers: {
                                "Content-Type": "application/json"
                            },
                            body: JSON.stringify({
                                "userId": sessionStorage.getItem("LoggedInId"),
                                "username": data[0].username,
                                "firstName": data[0].firstName,
                                "lastName": data[0].lastName,
                                "password": data[0].password,
                                "userLevel": userLevel
                            })
                        })
                            .then(
                                function(response) {
                                    if (response.status !== 200) {
                                        console.log('Update failed please try again. Status Code: ' +
                                            response.status);
                                        return;
                                    }
                                    response.json().then(function(data) {
                                        console.log(data);

                                        if(data.length !=0) {
                                            for (let i = 0; i < data.length; i++) {
                                                sessionStorage.setItem("LoggedInUsername", data[i].username);
                                                sessionStorage.setItem("LoggedInId", data[i].userId);
                                                sessionStorage.setItem("LoggedLevel", userLevel);

                                                // document.getElementById("alertArea").innerHTML = "";
                                                // document.getElementById("alertArea").innerHTML += '<div class="alert alert-primary" role="alert"><center><b>Profile Updated</b></center></div>';
                                                // getAll();
                                                // window.location.href = "myProfile.html";


                                            }
                                        }
                                        else{
                                            console.log("failed");
                                            alert("Update Failed Please Try Again :(")
                                        }
                                    });


                                })



                    }

                });

            });

}







