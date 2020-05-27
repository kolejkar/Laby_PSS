import React from "react";
import {Navbar, Nav} from 'react-bootstrap';
import { withRouter } from "react-router";

class SignedUpBar extends React.Component{
    render() {
        return (
            <Navbar bg="dark" variant="dark">
                <Navbar.Brand href="/menu">Menu</Navbar.Brand>
                <Nav className="mr-auto">
                    <Nav.Link href={"/profil/"+this.props.match.params.userId}>Profil</Nav.Link>
                    <Nav.Link href={"/delegations/"+this.props.match.params.userId}>Delegations</Nav.Link>
                </Nav>
            </Navbar>
        );
    }

}

export default SignedUpBar;