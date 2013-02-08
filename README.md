Spring MVC Example
==================

Build
-----
$mvn clean install<br/>

Run Jetty
---------
$cd {project}/web<br/>
$screen mvn -Djetty.port=9992 jetty:run &<br/>

Requests
--------
$curl http://localhost:9992/web/product?postcode=1 <br/>
$curl http://localhost:9992/web/product?postcode=2 <br/>
$curl http://localhost:9992/web/product?postcode=3 <br/>
$curl http://localhost:9992/web/product?postcode=4 <br/>
$curl http://localhost:9992/web/product?postcode=5 <br/>

Stop Jetty
----------
$cd {project}/web<br/>
$mvn -DSTOP.PORT=9993 jetty:stop<br/>
