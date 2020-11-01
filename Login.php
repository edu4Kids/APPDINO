<?php
    $con = mysqli_connect("localhost", "dustn1259", "ftp7988@", "dustn1259");
    
 
    $userID = $_POST["userID"];
    $userPassword = $_POST["userPassword"];
    
    $statement = mysqli_prepare($con, "SELECT * FROM USERS WHERE userID = ? AND userPassword = ?");
    mysqli_stmt_bind_param($statement, "ss", $userID, $userPassword);
    mysqli_stmt_execute($statement);
 
 
    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $userID, $userpassword, $usernickName,$userAge);
 
    $response = array();
    $response["success"] = false;
 
    while(mysqli_stmt_fetch($statement)) {
        $response["success"] = true;
        $response["userID"] = $userID;
        $response["userPassword"] = $userPassword;
        $response["usernickName"] = $usernickName;
        $response["userAge"] = $userAge;
        
    }
 
    echo json_encode($response);
?>
