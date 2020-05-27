import React from "react";
import {Jumbotron} from "react-bootstrap";


class Logged extends React.Component{
    render() {
        return (
            <div>

                <Jumbotron className={"bg-dark text-white"}>
                    <h1>Witajcie użytkoniku</h1>
                    <p>
                        Zostałeś zalogowany
                    </p>
                    <footer className="blockquote-footeru">
                        Piotr Kulesza
                    </footer>
                </Jumbotron>
            </div>

        );
    }

}

export default Logged;