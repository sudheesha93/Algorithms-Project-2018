<%--
  Created by IntelliJ IDEA.
  User: sreel
  Date: 4/27/2018
  Time: 10:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Vehicle Dispatching</title>
  <link href="bootstrap-3.3.7-dist/css/bootstrap-theme.min.css" rel="stylesheet">
  <link href="bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
  <link href="font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet">
  <link href="style.css" rel="stylesheet" type="text/css">

</head>
<body>

<header>
  <form action="/MyClass" method="post">
  <div class="row">
    <div class="hello">
      <h1>Vehicle Dispatching System </h1><br><br>
      <p>please select the available zipcodes from the following: 64110, 64130, 64127, 64134, 64155, 61255, 61232, 64149, 64064, 64143</p>
      <div class="button">
        <div class="row gap">
          <div class="col-md-4">
          <input type="text" name="zipcode" placeholder="Enter Zipcode" class="form-control"><br>
            <h4>Vehicle Type</h4>
            <select name="featured" size="1" id="item1">
                <option color class="demo1" value="fire">fire</option>
                <option class="demo1" value="police">police</option>
                <option class="demo1" value="ambulance">ambulance</option>
            </select>
          </div>
          <button type="submit" class ="btn btn1">Search</button>
        </div>
      </div>
    </div>
  </div>
</form>
</header>
<footer>
<section class="features">
  <h3 class="text-center">The vehicle will be on time</h3>
  <P class="copy">
    The emergency vehicles provided here are Police, Fire, Ambulance
  </P>
</section>

<section class="vehicle">
  <ul class="vehicle-showcase">
    <li>
      <figure class="vehicle-photo">
        <img src="img/image2.jpg">
      </figure>
    </li>
    <li>
      <figure class="vehicle-photo">
        <img src="img/image3.jpg">
      </figure>
    </li>
    <li>
      <figure class="vehicle-photo">
        <img src="img/image4.jpg">
      </figure>
    </li>
  </ul>
</section>
</footer>
</body>
</html>
