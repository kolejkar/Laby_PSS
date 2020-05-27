import React from "react";
import {Jumbotron} from "react-bootstrap";


class Welcome extends React.Component{
    render() {
        return (
            <div>

                <Jumbotron className={"bg-dark text-white"}>
                    <h1>Witajcie użytkoniku</h1>
                    <p>
                        Po zalogowaniu będziesz miał dostęp do swoich delegacji, będziesz mogł dodawać, usuwać i aktalizować sowje delegacje.
                    </p>
                    <footer className="blockquote-footeru">
                        Piotr Kulesza
                    </footer>
                </Jumbotron>
            </div>

        );
    }

}

export default Welcome;