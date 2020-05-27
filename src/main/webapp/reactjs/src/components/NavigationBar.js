import React from "react";
import {Navbar, Nav} from 'react-bootstrap';

class NavigationBar extends React.Component{
    render() {
        return (
            <Navbar bg="dark" variant="dark">
                <Navbar.Brand href="/">Start</Navbar.Brand>
                <Nav className="mr-auto">
                    <Nav.Link href="/login">Sign in</Nav.Link>
                    <Nav.Link href="/register">Register</Nav.Link>
                </Nav>
            </Navbar>
        );
    }

}

export default NavigationBar;