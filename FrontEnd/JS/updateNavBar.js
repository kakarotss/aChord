
$(function() {
   updateNavbar();
});

function updateNavbar(){
    // let username = '<%= Session["LoggedInUsername"] %>';
    let usernameSession = sessionStorage.getItem("LoggedInUsername");

    console.log(usernameSession);

    if(usernameSession != null){

        if(usernameSession != "admin") {
            let navElement = '<li><a class="nav-link" href="myProfile.html"><h5><i style="color: white" class="fas fa-user fa-fw"></i>My Profile</h5><span class="sr-only">(current)</span></a></li><li><a class="nav-link myClickable" onclick="logOut()"><h5><i style="color: indianred" class="fas fa-sign-out-alt fa-fw"></i>Log Out</h5><span class="sr-only">(current)</span></a></li>';
            document.getElementById("rightNav").innerHTML = "";

            document.getElementById("rightNav").innerHTML += navElement;
        }
        else{
            let navElement = '<li><a class="nav-link" href="admin.html"><h5><i style="color: white" class="fas fa-user-shield fa-fw"></i>Admin</h5><span class="sr-only">(current)</span></a></li><li><a class="nav-link myClickable" onclick="logOut()"><h5><i style="color: indianred" class="fas fa-sign-out-alt fa-fw"></i>Log Out</h5><span class="sr-only">(current)</span></a></li>';
            document.getElementById("rightNav").innerHTML = "";

            document.getElementById("rightNav").innerHTML += navElement;

        }

    }else{
        console.log("if not working")
    }
}


function logOut(){
    sessionStorage.removeItem("LoggedInUsername");
    sessionStorage.removeItem("LoggedInId");

    window.location.href = "Index.html";
}
