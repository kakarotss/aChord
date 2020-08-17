
function register() {
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
                    console.log('Register failed please try again. Status Code: ' +
                        response.status);
                    return;
                }
                response.json().then(function(data) {
                    console.log(data);

                    if(data.length !=0) {
                        for (let i = 0; i < data.length; i++) {
                            sessionStorage.setItem("LoggedInUsername", data[i].username);
                            sessionStorage.setItem("LoggedInId", data[i].userId);
                            sessionStorage.setItem("LoggedLevel", data[i].userLevel);
                            window.location.href = "Index.html";

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

