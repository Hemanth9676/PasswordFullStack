function checkPassword() {

    let password =
        document.getElementById("password").value;

    if (password === "") {

        alert("Please enter a password");

        return;
    }

    fetch(
        `/check-password?password=${encodeURIComponent(password)}`
    )

        .then(response => response.text())

        .then(data => {

            let result =
                document.getElementById("result");

            result.innerHTML =
                "Password Strength : " + data;


            if (data === "Password is valid.") {

                result.style.color = "green";
            }

            else {

                result.style.color = "red";
            }

        })

        .catch(error => {

            console.log(error);
        });
}