function validateAddItem () {
    var isValidItem = true;
    
    isValidItem = validateName();
    isValidItem = validatePrice();
    
    return isValidItem;
}

function validateName() {
    var isValid = true;
    
    if ($('#nameId').val() === "") {
        isValid = false;
        $('#nameId').css('border-color', 'red');
        $('#nameId').attr('placeholder', '(Required)  ex:Silly String');
    } else {
        $('#nameId').css('border-color', 'LightGray');
    }
    
    return isValid;
}

function validatePrice() {
    var isValid = true;
    
    // get the user input
    var price = $('#priceId').val();
    
    // get the regex
    var regexCharacter = "[A-z]";
    var regexCorrectFormat = "^[0-9]*\.[0-9]{2}$";
    
    // check if no value was entered
    if (price === "") {
        isValid = false;
        $('#priceId').css('border-color', 'red');
        $('#priceId').attr('placeholder', '(Required)  ex:7.35');
    // check if input has form #.##   
    }  else if (price.search(regexCharacter) !== -1) {
        isValid = false;
        $('#priceId').css('border-color', 'red');
        $('#invalidCharacter').show();
        $('#invalidFormat').hide();
        $('#invalidDollarSign').hide();
    // check if there is a dollar sign included
    } else if (price.search(regexCorrectFormat) === -1) {
        isValid = false;
        $('#priceId').css('border-color', 'red');
        $('#invalidFormat').show();
        $('#invalidDollarSign').hide();
        $('#invalidCharacter').hide();
    // check if there is a character in the string
    } else if (price.search("[$]") !== -1) {
        isValid = false;
        $('#priceId').css('border-color', 'red');
        $('#invalidDollarSign').show();
        $('#invalidFormat').hide();
        $('#invalidCharacter').hide();
    // validate that all information was correct and restore any error messages to default
    } else {
        $('#priceId').css('border-color', 'LightGray');
        $('#invalidDollarSign').hide();
        $('#invalidFormat').hide();
        $('#invalidCharacter').hide();
    }
   
    return isValid;
}


