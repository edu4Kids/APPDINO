<?php
    $con = mysqli_connect("localhost", "dustn1259", "data7988@","dustn1259");
    
 
     $userID = $_POST["userID"];
     $userPassword = $_POST["userPassword"];
     $usernickName = $_POST["usernickName"];
     $userAge = $_POST["userAge"];
    
    $statement = mysqli_prepare($con, "INSERT INTO USERS VALUES (?,?,?,?)");
    mysqli_stmt_bind_param($statement, "sssi", $userID, $userPassword, $usernickName,$userAge);
    mysqli_stmt_execute($statement);
 
 
    $response = array();
    $response["success"] = true;
   
   
    echo json_encode($response);
?>
