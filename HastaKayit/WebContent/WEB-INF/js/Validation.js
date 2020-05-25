function kontrol(id){
    var val = document.getElementById(id).value;
    if(val.trim().length == 0){
        alert(id + " alan Boş Geçilemez");
        return false;
        document.getElementById("btnGonder").disabled = true;
    }
    else if (isNaN(val) == true)
    {
        alert(id + " alan numara içermeli");
        document.getElementById("btnGonder").disabled = true;
    }
    else if(val.trim().length != 11)
        {
        alert(id + " alan 11 haneli olmalı");
        document.getElementById("btnGonder").disabled = true;
        }
    else
        {
        document.getElementById("btnGonder").disabled = false;

        }
}