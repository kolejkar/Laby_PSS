import React from "react";
import { FormErrors } from './FormErrors';

import {Form,Button,Card,Col} from 'react-bootstrap';
import { withRouter } from "react-router";

class NewPassword extends React.Component{

    componentDidMount() {
    }

    constructor (props) {
        super(props);
        this.state = {

            userId:this.props.match.params.userId,
            password: '',
            passwordR: ''
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



        return (

                <Card className={"border border-dark bg-dark text-white"}>
                    <Card.Header>Change Password</Card.Header>
                    <form onSubmit={this.submitPassword} id={"changePassordId"}>
                    <Card.Body>


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





                    </Card.Body>
                        <Card.Footer style={{"textAlign":"right"}}>
                            <Button size={"sm"} variant="success" type="submit">
                                Submit
                            </Button>
                        </Card.Footer>
                    </form>
                </Card>


        )
    }

}



export default NewPassword;