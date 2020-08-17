
$(function() {
   getAll();
});


function getAll() {
    let userId = sessionStorage.getItem("LoggedInId");
    let userLevel = sessionStorage.getItem("LoggedLevel");

    if(userId == null){
        userId = 0;

    }

    document.getElementById("courseArea").innerHTML="";
    fetch('http://localhost:9001/aChord/allCourses', {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
        "userId": userId,
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
                    if(userId !=0) {
                        document.getElementById("textArea").innerHTML += '<div class="alert alert-info " <h2><b>Your Current Level is: <b>' + userLevel + '</b></h2><div></div>';
                    }else{
                        document.getElementById("textArea").innerHTML += '<div class="alert alert-warning " <h2><b>Please sign in to access other courses</b></h2><div></div>';
                    }

                    if(data.length<=0){
                        let string = '<div class="alert alert-warning" <h2><b>No new courses available for you :(<b></b></h2><div></div>';
                        document.getElementById("textArea").innerHTML += string;
                    }
                    else {
                        for (let i = 0; i < data.length; i++) {
                            console.log("for loop")
                            if(data[i].courseLevel > userLevel){
                                let string = '<div class="card" ><img src="courseImg/locked.jpg" class="card-img-top disabled" id="image" alt="..."><div class="card-body disabled"><h5 class="card-title">' + data[i].courseName + '</h5><a  href="viewCourse.html?courseId=' + data[i].courseId + '" class="disabled btn btn-outline-primary btn-block">Level: '+data[i].courseLevel+' Required</a></div></div>';
                                document.getElementById("courseArea").innerHTML += string;

                            }else {
                                let string = '<div class="card" ><a href="viewCourse.html?courseId=' + data[i].courseId + '"><img src="courseImg/' + data[i].courseImg + '" class="card-img-top" id="image" alt="..."></a><div class="card-body"><a class="text-warning" href="viewCourse.html?courseId=' + data[i].courseId + '"><h5 class="card-title">' + data[i].courseName + '</h5></a><a href="viewCourse.html?courseId=' + data[i].courseId + '" class="btn btn-outline-primary btn-block">View</a></div></div>';
                                document.getElementById("courseArea").innerHTML += string;
                            }
                        }
                    }
                });
            })
}
