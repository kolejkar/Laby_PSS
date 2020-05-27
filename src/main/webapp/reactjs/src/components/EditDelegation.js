import React from "react";

import {Form,Button,Card,Col} from 'react-bootstrap';
import { withRouter } from "react-router";

class EditDelegation extends React.Component{
    constructor (props) {
        super(props);
        this.state = {

            userId:this.props.match.params.userId,
            description: '',
            dateTimeStart: new Date(),
            dateTimeStop: new Date(),
            travelDietAmount:'',
            breakfastNumber:'',
            dinnerNumber:'',
            supperNumber:'',
            transportType:'',
            ticketPrice:'',
            autoCapacity:false,
            km:'',
            accomodationPrice:'',
            otherTicketsPrice:'',
            otherOutlayDesc:'',
            otherOutlayPrice:'',

        }
        this.onElementChange=this.onElementChange.bind(this);
        this.submitDelegation=this.submitDelegation.bind(this);
    }
    submitDelegation(event){
        alert("Delegacja została dodana");
        event.preventDefault();
    }

    onElementChange(event){
        this.setState({
            [event.target.name]:event.target.value
        });

    }

    render() {

        return(
            <Card className={"border border-dark bg-dark text-white"}>
                <Card.Header>Add Delegation</Card.Header>
                <form onSubmit={this.submitDelegation} id={"addDelegation"}>
                    <Card.Body>
                        <Form.Row>
                            <Form.Group as={Col} controlId={"fromGridDescription"}>
                                <Form.Label>Description</Form.Label>
                                <Form.Control
                                    className={"bg-dark text-white"}
                                    name={"description"}
                                    value={this.state.description}
                                    onChange={this.onElementChange}
                                    type="text"
                                    placeholder="description" />
                            </Form.Group>
                        </Form.Row>
                        <Form.Row>
                            <Form.Group as={Col} controlId={"fromGridtravelDietAmount"}>
                                <Form.Label>travelDietAmount</Form.Label>
                                <Form.Control required
                                              className={"bg-dark text-white"}
                                              name={"travelDietAmount"}
                                              value={this.state.travelDietAmount}
                                              onChange={this.onElementChange}
                                              type="number"
                                              step="0.01"
                                              placeholder="travelDietAmount" />
                            </Form.Group>
                            <Form.Group as={Col} controlId={"fromGridbreakfastNumber"}>
                                <Form.Label>breakfastNumber</Form.Label>
                                <Form.Control required
                                              className={"bg-dark text-white"}
                                              name={"breakfastNumber"}
                                              value={this.state.breakfastNumber}
                                              onChange={this.onElementChange}
                                              type="number"

                                              placeholder="breakfastNumber" />
                            </Form.Group>

                        </Form.Row>
                        <Form.Row>
                            <Form.Group as={Col} controlId={"fromGriddinnerNumber"}>
                                <Form.Label>dinnerNumber</Form.Label>
                                <Form.Control required
                                              className={"bg-dark text-white"}
                                              name={"dinnerNumber"}
                                              value={this.state.dinnerNumber}
                                              onChange={this.onElementChange}
                                              type="number"
                                              placeholder="dinnerNumber" />
                            </Form.Group>
                            <Form.Group as={Col} controlId={"fromGridsupperNumber"}>
                                <Form.Label>supperNumber</Form.Label>
                                <Form.Control required
                                              className={"bg-dark text-white"}
                                              name={"supperNumber"}
                                              value={this.state.supperNumber}
                                              onChange={this.onElementChange}
                                              type="number"

                                              placeholder="supperNumber" />
                            </Form.Group>

                        </Form.Row>
                        <Form.Row>
                            <Form.Group as={Col} controlId={"fromGridtransportType"}>
                                <Form.Label>transportType</Form.Label>
                                <Form.Control
                                    className={"bg-dark text-white"}
                                    name={"transportType"}
                                    value={this.state.transportType}
                                    onChange={this.onElementChange}
                                    type="text"
                                    placeholder="transportType" >
                                </Form.Control>
                            </Form.Group>
                            <Form.Group as={Col} controlId={"fromGridticketPrice"}>
                                <Form.Label>ticketPrice</Form.Label>
                                <Form.Control
                                    className={"bg-dark text-white"}
                                    name={"ticketPrice"}
                                    value={this.state.ticketPrice}
                                    onChange={this.onElementChange}
                                    type="number"
                                    step="0.01"
                                    placeholder="ticketPrice" />
                            </Form.Group>

                        </Form.Row>
                        <Form.Row>
                            <Form.Group as={Col} controlId={"fromGridautoCapacity"}>
                                <Form.Label>autoCapacity</Form.Label>
                                <Form.Control required
                                              className={"bg-dark text-white"}
                                              name={"autoCapacity"}
                                              value={this.state.autoCapacity}
                                              onChange={this.onElementChange}
                                              type="checkbox"
                                              placeholder="autoCapacity" >
                                </Form.Control>
                            </Form.Group>
                            <Form.Group as={Col} controlId={"fromGridkm"}>
                                <Form.Label>km</Form.Label>
                                <Form.Control
                                    className={"bg-dark text-white"}
                                    name={"km"}
                                    value={this.state.km}
                                    onChange={this.onElementChange}
                                    type="number"
                                    placeholder="km" />
                            </Form.Group>
                        </Form.Row>
                        <Form.Row>
                            <Form.Group as={Col} controlId={"fromGridaccomodationPrice"}>
                                <Form.Label>accomodationPrice</Form.Label>
                                <Form.Control
                                    className={"bg-dark text-white"}
                                    name={"accomodationPrice"}
                                    value={this.state.accomodationPrice}
                                    onChange={this.onElementChange}
                                    type="number"
                                    step="0.01"
                                    placeholder="accomodationPrice" >
                                </Form.Control>
                            </Form.Group>
                            <Form.Group as={Col} controlId={"fromGridotherTicketsPrice"}>
                                <Form.Label>otherTicketsPrice</Form.Label>
                                <Form.Control
                                    className={"bg-dark text-white"}
                                    name={"otherTicketsPrice"}
                                    value={this.state.otherTicketsPrice}
                                    onChange={this.onElementChange}
                                    type="number"
                                    step="0.01"
                                    placeholder="otherTicketsPrice" />
                            </Form.Group>
                        </Form.Row>
                        <Form.Row>
                            <Form.Group as={Col} controlId={"fromGridotherOutlayDesc"}>
                                <Form.Label>otherOutlayDesc</Form.Label>
                                <Form.Control
                                    className={"bg-dark text-white"}
                                    name={"otherOutlayDesc"}
                                    value={this.state.otherOutlayDesc}
                                    onChange={this.onElementChange}
                                    type="number"
                                    step="0.01"
                                    placeholder="otherOutlayDesc" >
                                </Form.Control>
                            </Form.Group>
                            <Form.Group as={Col} controlId={"fromGridotherOutlayPrice"}>
                                <Form.Label>otherOutlayPrice</Form.Label>
                                <Form.Control
                                    className={"bg-dark text-white"}
                                    name={"otherOutlayPrice"}
                                    value={this.state.otherOutlayPrice}
                                    onChange={this.onElementChange}
                                    type="number"
                                    step="0.01"
                                    placeholder="otherOutlayPrice" />
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

export default EditDelegation;