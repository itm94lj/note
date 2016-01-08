<html>
<head>
  <style type="text/css">
div#header {background-color:#99bbbb;width:500px}
div#Key {background-color:#ffff99;height:200px;width:150px;float:left;}
div#content {background-color:#EEEEEE;height:200px;width:350px;float:left;}
h1 {margin-bottom:0;}
h2 {margin-bottom:0;font-size:18px;}
div#content input {background-color:#EEEEEE; width:350px; height:160px}
div#Key input {background-color:#EEEEE; width:140px}
  </style>
  <script type="text/javascript">
    function AddNote()
    {
        var KeyValue   = document.getElementById("note_key").value;
        var ValueValue = document.getElementById("note_value").value;
        
        httpRe = new XMLHttpRequest();
        httpRe.onreadystatechange=function()
        {
            if (httpRe.readyState == 4 &&
                httpRe.status     == 200)
            {
                document.getElementById("note_value").value = 
                    httpRe.responseText;
            }
        }
        httpRe.open("GET", "procadd?key="+KeyValue+"&value="+ValueValue,
        false);
        httpRe.send();
    }
  </script>
</head>
<body>
<div id="header">
<h1>Enter key-value pairs</h1>
</div>
<div id="Key">
<h2>Key:</h2>
<input type="text" id="note_key">
</div>
<div id="content">
<h2>Value:</h2>
<input type="textarea" id="note_value">
</div>
<button type="button" onclick="AddNote()">Add Note</button>
</body>
</html>
