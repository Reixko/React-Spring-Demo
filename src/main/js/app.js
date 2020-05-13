'use strict';

import React, {Component} from "react";
import * as ReactDOM from "react-dom";

class App extends Component {
    constructor(props) {
        super(props);

        this.state = {
            data: '',
            newData: ''
        };

        this.loadData = this.loadData.bind(this);
        this.saveData = this.saveData.bind(this);
    }

    componentDidMount() {
        this.loadData();
    }

    loadData() {
        fetch('api/data').then(response => response.json()).then(data => this.setState({data: data.data}));
    }

    saveData() {
        const headers = {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        };

        const csrfHeader = document.querySelector('meta[name="_csrf_header"]').content;
        const csrfToken = document.querySelector('meta[name="_csrf"]').content;

        headers[csrfHeader] = csrfToken;

        fetch('api/data', {
            method: 'POST',
            headers,
            body: this.state.newData
        }).then();
    }

    render() {
        return (
            <div>
                <div>Data: {this.state.data}</div>
                <div>
                    <input type="text" value={this.state.newData}
                           onChange={$event => this.setState({newData: $event.target.value})}/>
                </div>
                <div>
                    <button onClick={this.saveData}>Save Data</button>
                    <button onClick={this.loadData}>Load Data</button>
                </div>
            </div>
        )
    }
}

ReactDOM.render(
    <App/>,
    document.getElementById('react')
);