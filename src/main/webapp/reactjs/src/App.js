import React from 'react';
import './App.css';

import {Container, Row ,Col} from 'react-bootstrap';
import {
    BrowserRouter as Router,
    Switch,
    Route
} from 'react-router-dom'

import NavigationBar from "./components/NavigationBar";
import Welcome from "./components/Welcome";
import Footer from "./components/Footer";
import Login from "./components/Login";
import Register from "./components/Register";
import SignedUpBar from "./components/SignedUpBar";
import Profil from "./components/Profil";
import NewPassword from "./components/NewPassword";
import NewDelegation from "./components/NewDelegation";
import WelcomeUser from "./components/WelcomeUser";
import Delegations from "./components/Delegations";
import EditDelegation from "./components/EditDelegation";
import Logged from "./components/Logged"

function App() {

    const marginTop={
        marginTop:"20px"
    };

  return (
    <Router>
        <Switch>
            <Route path="/" exact component={NavigationBar}/>
            <Route path="/login" exact component={NavigationBar}/>\
            <Route path="/register" exact component={NavigationBar}/>
            <Route path={"/Logged"} exact component={NavigationBar}/>
            <Route path="/menu/:userId" exact component={SignedUpBar}/>
            <Route path="/profil/:userId" exact component={SignedUpBar}/>\
            <Route path="/delegations/:userId" exact component={SignedUpBar}/>
            <Route path="/editdelegation/:userId/:delegationId" exact component={SignedUpBar}/>
            <Route path="/editpass/:userId" exact component={SignedUpBar}/>
            <Route path="/adddelegation/:userId" exact component={SignedUpBar}/>
        </Switch>

        <Container >
            <Row>
                <Col lg={12} style={marginTop}>
                    <Switch>
                        <Route path="/" exact component={Welcome}/>
                        <Route path="/login" exact component={Login}/>
                        <Route path="/register" exact component={Register}/>
                        <Route path={"/Logged"} exact component={Logged}/>
                        <Route path="/menu/:userId" exact component={WelcomeUser}/>
                        <Route path="/profil/:userId" exact component={Profil}/>
                        <Route path="/delegations/:userId" exact component={Delegations}/>
                        <Route path="/editdelegation/:userId/:delegationId" exact component={EditDelegation}/>
                        <Route path="/editpass/:userId" exact component={NewPassword}/>
                        <Route path="/adddelegation/:userId" exact component={NewDelegation}/>
                    </Switch>

                </Col>


            </Row>

        </Container>

        <Footer/>


    </Router>
  );
}

export default App;
