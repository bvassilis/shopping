Spring MVC Example
==================

Build
-----
$mvn clean install

Run Jetty
---------
$cd {project}/web
$screen mvn -Djetty.port=9992 jetty:run &

Requests
--------
$curl http://localhost:9992/web/product?postcode=1 </br>
$curl http://localhost:9992/web/product?postcode=2 </br>
$curl http://localhost:9992/web/product?postcode=3 </br>
$curl http://localhost:9992/web/product?postcode=4 </br>
$curl http://localhost:9992/web/product?postcode=5 </br>

Stop Jetty
----------
$cd {project}/web
$mvn -DSTOP.PORT=9993 jetty:stop
