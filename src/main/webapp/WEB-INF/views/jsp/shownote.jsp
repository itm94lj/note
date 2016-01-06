<!DOCTYPE html>
<html lang="en">

<head>
  <style type="text/css">
div#header {background-color:#99bbbb;width:500px}
div#Key {background-color:#ffff99;height:200px;width:150px;float:left;}
div#content {background-color:#EEEEEE;height:200px;width:350px;float:left;}
h1 {margin-bottom:0;}
h2 {margin-bottom:0;font-size:18px;}
  </style>

  <script type="text/javascript">
    function getValueFromServ(input)
    {
        key = input.value;

        httpRe = new XMLHttpRequest();
        httpRe.onreadystatechange=function()
        {
            if (httpRe.readyState == 4 &&
                httpRe.status == 200)
            {
                document.getElementById("content").innerHTML =
                  httpRe.responseText;
            }
        }
        httpRe.open("GET", "search?key="+key,  false);
        httpRe.send();
    }
  </script>
</head>

<body>
<div id="header">
<h1>App provided by itm94lj</h1>
</div>
<div id="Key">
<h2>Key:</h2>
<input type="text" id="Key_text" onchange="getValueFromServ(this)">
</div>
<div id="content"></div>
</div>

</body>

</html>
