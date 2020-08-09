$(function() {
    getAll();
});

function getAll() {
    // document.getElementById("tbody").innerHTML="";
    fetch('http://localhost:9000/aChord/myProfile', {
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

                    }
                });
            })
}

function updateUser(){
    let userId = sessionStorage.getItem("LoggedInId");
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    let firstName = document.getElementById("firstName").value;
    let lastName = document.getElementById("lastName").value;
    let email = document.getElementById("email").value;

    fetch(`http://localhost:9000/aChord/Register`, {
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
                    }
                });


                // else{
                //     sessionStorage.setItem("LoggedInUser", username);
                //
                // }


            })
}
