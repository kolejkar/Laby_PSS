import React from "react";
import DateTimePicker from 'react-datetime-picker';
import {Card, Nav, Table} from "react-bootstrap";
import axios from "axios";

class Delegations extends React.Component{

    constructor(props) {
        super(props);
        this.state = {
            userId : this.props.match.params.userId,
            delegations:[]
        }

    }

    componentDidMount() {
        const url = "http://localhost:8080/getAllDelegationsByUserOrderByDateStartDesc?userId=1";

        axios.get("http://localhost:8080/getAllDelegationsByUserOrderByDateStartDesc", {params: {
                userId: this.state.userId
            }})
            .then(response => response.data)
            .then((data) => {
                this.setState({delegations: data})
            });

         console.log(this.state.delegations.length);
    }

    render() {
        return (
            <Card className={"border border-dark bg-dark text-white"} >
                <Card.Header>Delegations  <Nav className="mr-auto"><Nav.Link href={"/adddelegation/"+this.props.match.params.userId}>Add</Nav.Link>
                    </Nav></Card.Header>
                <Card.Body>
                    <Table bordered hover striped variant={"dark"}>
                        <thead>
                        <tr>
                            <th>Edit</th>
                            <th>Id</th>
                            <th>UserId</th>
                            <th>Description</th>
                            <th>Start</th>
                            <th>Stop</th>
                            <th>Travel Diet</th>
                            <th>Breakfest Number</th>
                            <th>Dinder Number</th>
                            <th>Supper Number</th>
                            <th>Transport Type</th>
                            <th>Ticket Price</th>
                            <th>Auto Capacity</th>
                            <th>Km</th>
                            <th>Accomodation Price</th>
                            <th>Other Tickets Price</th>
                            <th>Other Outlay Desc</th>
                            <th>Other Outlay Price</th>

                        </tr>
                        </thead>
                        <tbody>
                        {
                            this.state.delegations.length === 0 ?
                                <tr>
                                    <td colSpan="19">For now empty</td>
                                </tr>
                                :
                                this.state.delegations.map((delegation) =>
                                    <tr key={delegation.delegationId}>
                                        <td><Nav><Nav.Link href={"/editdelegation/"+this.state.userId+"/"+delegation.delegationId}></Nav.Link></Nav></td>
                                        <td>{delegation.delegationId}</td>
                                        <td>{delegation.userId}</td>
                                        <td>{delegation.description}</td>
                                        <td>{delegation.dateTimeStart}</td>
                                        <td>{delegation.dateTimeStop}</td>
                                        <td>{delegation.travelDietAmount}</td>
                                        <td>{delegation.breakfastNumber}</td>
                                        <td>{delegation.dinnerNumber}</td>
                                        <td>{delegation.supperNumber}</td>
                                        <td>{delegation.transportType}</td>
                                        <td>{delegation.ticketPrice}</td>
                                        <td>{delegation.autoCapacity}</td>
                                        <td>{delegation.km}</td>
                                        <td>{delegation.accomodationPrice}</td>
                                        <td>{delegation.otherTicketsPrice}</td>
                                        <td>{delegation.otherOutlayDesc}</td>
                                        <td>{delegation.otherOutlayPrice}</td>

                                    </tr>
                                )
                        }
                        </tbody>
                    </Table>
                </Card.Body>
            </Card>
        );
    }

}

export default Delegations;