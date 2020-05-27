import React from "react";
import {Jumbotron} from "react-bootstrap";


class WelcomeUser extends React.Component{
    render() {
        return (
            <div>

                <Jumbotron className={"bg-dark text-white"}>
                    <h1>Witaj</h1>
                    <p>
                        Możesz teraz edytować, dodawać delegacje w zakłądce Delegations.

                    </p>
                    <p>
                         W zakładce Profile możesz sprawdzić swoje dane oraz zmienić hasło.
                     </p>
                    <footer className="blockquote-footeru">
                        Piotr Kulesza
                    </footer>
                </Jumbotron>
            </div>

        );
    }

}

export default WelcomeUser;