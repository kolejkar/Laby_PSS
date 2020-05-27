import React from "react";
import { withRouter } from "react-router";
import axios from 'axios';

import {Card, Nav, Navbar, Table} from 'react-bootstrap';

class Profil extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
            userId : this.props.match.params.userId,
            users:[]
        }

    }

    componentDidMount() {
        const url = "http://localhost:8080/getUser?userId=1";

        axios.get("http://localhost:8080/getUser", {params: {
            userId: this.state.userId
            }})
            .then(response => response.data)
            .then((data) => {
                this.setState({users: data})
            });

       // console.log(this.state.users);
    }

    render() {
        return (
            <Card className={"border border-dark bg-dark text-white"}>
                <Card.Header>Profil</Card.Header>
                <Card.Body>
                    <Table bordered hover striped variant={"dark"}>
                        <thead>
                        <tr>
                            <th>Opis</th>
                            <th>Dane</th>
                            <th>Edit</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>Name</td>
                            {this.state.users.map((user) =>
                                <td key={user.userId}>{user.name}</td>
                            )
                            }
                            <td></td>
                        </tr>
                        <tr>
                            <td>Last Name</td>
                            {this.state.users.map((user) =>
                                <td key={user.userId}>{user.lastName}</td>
                            )
                            }
                            <td></td>
                        </tr>
                        <tr>
                            <td>Company Name</td>
                            {this.state.users.map((user) =>
                                <td key={user.userId}>{user.companyName}</td>
                            )
                            }
                            <td></td>
                        </tr>
                        <tr>
                            <td>Company Nip</td>
                            {this.state.users.map((user) =>
                                <td key={user.userId}>{user.companyNip}</td>
                            )
                            }
                            <td></td>
                        </tr>
                        <tr>
                            <td>Company Adress</td>
                            {this.state.users.map((user) =>
                                <td key={user.userId}>{user.companyAddress}</td>
                            )
                            }
                            <td></td>
                        </tr>
                        <tr>
                            <td>Email</td>
                            {this.state.users.map((user) =>
                                <td key={user.userId}>{user.email}</td>
                            )
                            }
                            <td></td>
                        </tr>
                        <tr>

                                <td>Password</td>
                            {this.state.users.map((user) =>
                                <td key={user.userId}>{user.password}</td>
                            )
                            }
                                <td><Nav ><Nav.Link href={"/editpass/"+this.state.userId}>Edytuj</Nav.Link></Nav></td>

                        </tr>
                        </tbody>
                    </Table>
                </Card.Body>
            </Card>
        );
    }

}

export default Profil;