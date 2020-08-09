
$(function() {
   getAll();
});


function getAll() {
    document.getElementById("tbody").innerHTML="";
    fetch('http://localhost:9000/aChord/allUsers', {
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
                    console.log(data);
                    for (let i = 0; i < data.length; i++) {
                        let string = '<tr><td>'+data[i].userId+'</td><td><input class="bg-dark text-light" id="fname'+data[i].userId+'" value="'+data[i].firstName+'"></td><td><input class="bg-dark text-light" id="lname'+data[i].userId+'" value="'+data[i].lastName+'"></td><td><input class="bg-dark text-light" id="uname'+data[i].userId+'" value="'+data[i].username+'"></td><td><input class="bg-dark text-light" id="password'+data[i].userId+'" value="'+data[i].userPassword+'"></td><td><input class="bg-dark text-light" id="email'+data[i].userId+'" value="'+data[i].email+'"></td><td><button class ="btn btn-danger btn-block" onclick= "deleteRecord(' +data[i].userId+ ')">X</button></td><td><button onClick="updateRecord('+data[i].userId+')" class =" btn btn-warning btn-block">Update</button></td></tr>';
                        document.getElementById("tbody").innerHTML+=string;

                    }
                });
            })
}

function deleteRecord(id) {
    // document.getElementById("tbody").innerHTML="";
    fetch(`http://localhost:9000/aChord/deleteAccount`, {
        method: "DELETE",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            "userId": id,
        })
    })
        .then(
            function(response) {
                if (response.status !== 200) {
                    console.log('Looks like there was a problem. Status Code: ' +
                        response.status);
                    return;
                }
                getAll();

            })
}


function updateRecord(id) {
    let userId = id;
    let username = document.getElementById("uname"+id+"").value;
    let userPassword = document.getElementById("password"+id+"").value;
    let firstName = document.getElementById("fname"+id+"").value;
    let lastName = document.getElementById("lname"+id+"").value;
    let email = document.getElementById("email"+id+"").value;

    fetch(`http://localhost:9000/aChord/addUsers`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            userId: userId,
            username: username,
            userPassword: userPassword,
            firstName: firstName,
            lastName: lastName,
            email: email
        })
    })
        .then(
            function(response) {
                if (response.status !== 200) {
                    console.log('Looks like there was a problem. Status Code: ' +
                        response.status);
                    return;
                }
                getAll();

            })
}

function insertRecord() {

    let username = document.getElementById("username").value;
    let userPassword = document.getElementById("password").value;
    let firstName = document.getElementById("firstName").value;
    let lastName = document.getElementById("lastName").value;
    let email = document.getElementById("email").value;

    fetch(`http://localhost:9000/aChord/addUsers`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            username: username,
            userPassword: userPassword,
            firstName: firstName,
            lastName: lastName,
            email: email
        })
    })
        .then(
            function(response) {
                if (response.status !== 200) {
                    console.log('Looks like there was a problem. Status Code: ' +
                        response.status);
                    return;
                }
                getAll();

            })
}

function createTr(){
    getAll();

    let string = '<tr><td></td><td><input id = "firstName" type= "text"></td><td><input id = "lastName" type= "text"><td><input id = "username" type= "text"><td><input id = "password" type= "password"><td><input id = "email" type= "email"><td><button class ="btn btn-warning btn-block" onclick= "insertRecord()">Insert</button></td></tr>';

    document.getElementById("tbody").innerHTML+=string;
}
