const statusErr = 'error';
const messageErr = 'Data field is not empty';

const statusSuccess = 'success';
const messageSuccess = 'You are created an account';

const statusEmail = 'error email';
const messageEmail = 'Email is not valid';

const statusPassword = 'error password';
const messagePassword = 'Password is must be long 8';


const errMsg = {statusErr, messageErr};
const successMsg = {statusSuccess, messageSuccess};
const emailMsg = {statusEmail, messageEmail}
const passwordMsg = {statusPassword, messagePassword};

$('#signUp').on('click', () => {
    checkNotEmpty();
});

function checkNotEmpty() {
    let userName = $('#username').val();
    let password = $('#password').val();
    let email = $('#email').val();
    if (userName === '' || password === '' || email === '') {
        $('#status').text(errMsg.statusErr)
        $('#message').text(errMsg.messageErr);
    } else {
        if (password.length <= 8) {
            $('#status').text(passwordMsg.statusPassword)
            $('#message').text(passwordMsg.messagePassword);
        } else if (validateEmail(email) === null) {
            $('#status').text(emailMsg.statusEmail)
            $('#message').text(emailMsg.messageEmail);
        } else {
            let sendSignUpObj = {userName, password, email};
            sendObjectSignUp(sendSignUpObj);
        }
    }
}

function sendObjectSignUp(sendSignUpObj) {
    $.ajax({
        url: '/signup',
        type: 'POST',
        cache: false,
        data: sendSignUpObj,
        success: function (data) {
            let userName = data.userName;
            let password = data.password;
            let email = data.email;
            let error = data.error;
            if (error !== '') {
                $('#status').text(errMsg.statusErr);
                $('#message').text(error);
                $('#username').text(userName);
                $('#password').val(password);
                $('#email').val(email);
            } else {
                $('#status').text(successMsg.statusSuccess)
                $('#message').text(successMsg.messageSuccess);
                $('#username').val('');
                $('#password').val('');
                $('#email').val('');
            }

        },
        error: function () {
            alert('error');
        }
    });
}

let validateEmail = (email) => {
    return String(email)
        .toLowerCase()
        .match(
            /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
        );
};

