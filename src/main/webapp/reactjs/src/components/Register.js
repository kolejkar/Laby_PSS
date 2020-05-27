import React from "react";

import {Form,Button,Card,Col} from 'react-bootstrap';

class Register extends React.Component{
    constructor (props) {
        super(props);
        this.state = {
            email: '',
            password: '',
            passwordR: '',
            companyName:'',
            companyAddress:'',
            companyNip:'',
            name:'',
            lastName:'',
            status:true,

        }
        this.passChange=this.passChange.bind(this);
        this.submitPassword=this.submitPassword.bind(this);
    }
    submitPassword(event){
        if (this.state.password===this.state.passwordR)
            alert("Hasła są identyczne");
        else
            alert("Hasła nie sią identyczne");
        event.preventDefault();
    }

    passChange(event){
        this.setState({
            [event.target.name]:event.target.value
        });

    }

    render() {

        return(
            <Card className={"border border-dark bg-dark text-white"}>
                <Card.Header>Register</Card.Header>
                <form onSubmit={this.submitPassword} id={"changePassordId"}>
                    <Card.Body>
                        <Form.Row>
                            <Form.Group as={Col} controlId="formGridEmail">
                                <Form.Label>Email address</Form.Label>
                                <Form.Control required
                                              className={"bg-dark text-white"}
                                              name={"email"}
                                              value={this.state.email}
                                              onChange={this.passChange}
                                              type="email"
                                              placeholder="Enter email" />

                            </Form.Group>
                        </Form.Row>


                        <Form.Row>
                            <Form.Group as={Col} controlId={"fromGridPass"}>
                                <Form.Label>Password</Form.Label>
                                <Form.Control required
                                              className={"bg-dark text-white"}
                                              name={"password"}
                                              value={this.state.password}
                                              onChange={this.passChange}
                                              type="password"
                                              placeholder="Password" />
                            </Form.Group>
                            <Form.Group as={Col} controlId={"fromGridPass2"}>
                                <Form.Label>Password 2</Form.Label>
                                <Form.Control required
                                              className={"bg-dark text-white"}
                                              name={"passwordR"}
                                              value={this.state.passwordR}
                                              onChange={this.passChange}
                                              type="password"
                                              placeholder="Password 2" />
                            </Form.Group>
                        </Form.Row>
                        <Form.Row>
                                <Form.Group as={Col} controlId={"fromGridName"}>
                                    <Form.Label>Name</Form.Label>
                                    <Form.Control required
                                                  className={"bg-dark text-white"}
                                                  name={"name"}
                                                  value={this.state.name}
                                                  onChange={this.passChange}
                                                  type="text"
                                                  placeholder="Name" />
                                </Form.Group>
                                <Form.Group as={Col} controlId={"fromGridLastName"}>
                                    <Form.Label>Lastname</Form.Label>
                                    <Form.Control required
                                                  className={"bg-dark text-white"}
                                                  name={"lastName"}
                                                  value={this.state.lastName}
                                                  onChange={this.passChange}
                                                  type="text"
                                                  placeholder="LastName" />
                                </Form.Group>
                        </Form.Row>
                        <Form.Row>
                            <Form.Group as={Col} controlId={"fromGridCompanyName"}>
                                <Form.Label>Company Name</Form.Label>
                                <Form.Control required
                                              className={"bg-dark text-white"}
                                              name={"companyName"}
                                              value={this.state.companyName}
                                              onChange={this.passChange}
                                              type="text"
                                              placeholder="Company Name" />
                            </Form.Group>
                            <Form.Group as={Col} controlId={"fromGridLastCompanyNip"}>
                                <Form.Label>Company Nip</Form.Label>
                                <Form.Control required
                                              className={"bg-dark text-white"}
                                              name={"companyNip"}
                                              value={this.state.companyNip}
                                              onChange={this.passChange}
                                              type="text"
                                              placeholder="Company Nip" />
                            </Form.Group>
                        </Form.Row>
                        <Form.Row>

                            <Form.Group as={Col} controlId={"fromGridLastCompanyAddress"}>
                                <Form.Label>Company Address</Form.Label>
                                <Form.Control required
                                              className={"bg-dark text-white"}
                                              name={"companyAddress"}
                                              value={this.state.companyAddress}
                                              onChange={this.passChange}
                                              type="text"
                                              placeholder="Company Address" />
                            </Form.Group>
                        </Form.Row>





                    </Card.Body>
                    <Card.Footer style={{"textAlign":"right"}}>
                        <Button size={"sm"} variant="success" type="submit">
                            Submit
                        </Button>
                    </Card.Footer>
                </form>
            </Card>
        );
    }

}

export default Register;