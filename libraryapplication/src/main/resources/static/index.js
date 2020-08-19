import React from "react"
import ReactDOM from "react-DOM"
import Practice from "./Practice"

ReactDOM.render(<Practice/>,document.getElementById("root1"));

document.getElementById("root1").innerHTML = "Hello";


function Practice(){
	return (
		<div>
			I'm just chillin in here dawg
		</div>
	)
}



