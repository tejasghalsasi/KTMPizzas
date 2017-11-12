<?php
   $name=$_REQUEST["name"];
 $address=$_REQUEST["address"];
  $phoneno=$_REQUEST["phoneno"];
  $emailid=$_REQUEST["emailid"];
  $registeredto=$_REQUEST["registeredto"];
  
  $conn=mysqli_connect("sql307.0fees.net","fees0_14359360","jnanesh","fees0_14359360_ktm");
    if(!$conn)
    {
    die('error occured');
    }  
    $a="INSERT INTO cust"." VALUES('$name','$address','$phoneno','$emailid','$registeredto',null)";
    $result=  mysqli_query($conn,$a);
    if(!$result)
    {
    die('error occured');
    }
    mysqli_close($conn);
?>    