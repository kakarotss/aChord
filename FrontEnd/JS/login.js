
function login() {
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;

    fetch(`http://localhost:9003/aChord/Login`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            "username": username,
            "userPassword": password
        })
    })
        .then(
            function(response) {
                if (response.status !== 200) {
                    console.log('Login failed please try again. Status Code: ' +
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
                            console.log("passed");

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

