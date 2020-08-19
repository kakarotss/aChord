$(function() {
    getAll();
    getMyLine();
});



function getAll() {

    fetch('http://localhost:9001/aChord/myProfile', {
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

                        document.getElementById("username").value= data[0].username;
                        document.getElementById("password").value= data[0].userPassword;
                        document.getElementById("firstName").value= data[0].firstName;
                        document.getElementById("lastName").value= data[0].lastName;
                        document.getElementById("email").value= data[0].email;
                        document.getElementById("level").innerHTML= '<div class="alert alert-dark">\n' +
                            '                                                    <h4>Your Current Level is: <b id="userLevel">'+data[0].userLevel+'</b></h4>\n' +
                            '                                                </div>';

                    }

                });

            });

}


function removeLine(id) {

    fetch('http://localhost:9001/aChord/removeLine', {
        method: "DELETE",
        headers: {
            "Content-Type": "application/json"
        },

        body: JSON.stringify({
            "courseLineId": id
        })
    })
        .then(
            function(response) {
                if (response.status !== 200) {
                    console.log('Looks like there was a problem. Status Code: ' +
                        response.status);
                    return;
                }else{
                    getMyLine();
                }


            });

}


function updateUser(){
    let userId = sessionStorage.getItem("LoggedInId");
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    let firstName = document.getElementById("firstName").value;
    let lastName = document.getElementById("lastName").value;
    let email = document.getElementById("email").value;

    fetch(`http://localhost:9001/aChord/Register`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            "userId": userId,
            "username": username,
            "userPassword": password,
            "email": email,
            "firstName": firstName,
            "lastName": lastName
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

                            document.getElementById("alertArea").innerHTML = "";
                            document.getElementById("alertArea").innerHTML += '<div class="alert alert-primary" role="alert"><center><b>Profile Updated</b></center></div>';
                            getAll();
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



function getMyLine() {

    fetch('http://localhost:9001/aChord/myCourseLine', {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },

        body: JSON.stringify({
            "userId": sessionStorage.getItem("LoggedInId"),
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

                    document.getElementById("nav-profile").innerHTML = "";

                    for(let i=  0; i < data.length; i++){


                        fetch('http://localhost:9001/aChord/idCourses', {
                            method: "POST",
                            headers: {
                                "Content-Type": "application/json"
                            },

                            body: JSON.stringify({
                                "courseId": data[i].courseId
                            })
                        })
                            .then(
                                function(response) {
                                    if (response.status !== 200) {
                                        console.log('Looks like there was a problem. Status Code: ' +
                                            response.status);
                                        return;
                                    }
                                    response.json().then(function(data1) {
                                        // console.log(data1);

                                        let element;
                                        if(data[i].courseStatus == "Done"){
                                            element = '<div class="alert alert-info alert-dismissible fade show" role="alert"><strong><a href="viewMyCourse.html?courseId=' + data[i].courseId + '&courseLineId=' + data[i].courseLineId + '&status=' + data[i].courseStatus + '&userLevel=' + document.getElementById("userLevel").innerText + '" class="text-info">Name: ' + data1.courseName + '  </a></strong><button onclick="removeLine(' + data[i].courseLineId + ')" class="btn btn-sm btn-danger text-light float-lg-right pt">Remove</button><hr><strong class="text-success"> Status: ' + data[i].courseStatus + '</strong></div><hr>'


                                        }else {
                                            element = '<div class="alert alert-info alert-dismissible fade show" role="alert"><strong><a href="viewMyCourse.html?courseId=' + data[i].courseId + '&courseLineId=' + data[i].courseLineId + '&status=' + data[i].courseStatus + '&userLevel=' + document.getElementById("userLevel").innerText + '" class="text-info">Name: ' + data1.courseName + '  </a></strong><button onclick="removeLine(' + data[i].courseLineId + ')" class="btn btn-sm btn-danger text-light float-lg-right pt">Remove</button><hr><strong class="text-danger"> Status: ' + data[i].courseStatus + '</strong></div><hr>'

                                        }
                                        document.getElementById("nav-profile").innerHTML += element;



                                    });

                                });



                    }

                    console.log(data);

                });

            });


}
