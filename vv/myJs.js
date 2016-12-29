function processRegisterForm(input1)
{
	var letters = /^[A-Za-z]+$/;  
      if(!input1.value.match(letters))   
      {  
      alert('Please fill in your details properly');  
      return false;  
      }  


	var fn=document.wtmregister.fname.value;
	var em=document.wtmregister.usremail.value;
	var pno=document.wtmregister.phoneno.value;
	var disp = '<div> First Name: ' + fn +'<br>'+'Email:'+em+'<br>'+'Phoneno:'+pno+'<br>'+ '</div>';

  /*  document.getElementById("memberform").innerHTML += disp; */
    

}
  