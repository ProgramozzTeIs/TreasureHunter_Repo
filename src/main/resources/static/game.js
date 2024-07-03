/** GLOBAL VARIABLE */

let clickCounter = 0;
let win = 0; // 1: win, 2: loose, 0: draw
let lifes = 2;

/** GLOBAL VARIABLE */



window.onload = function() {
	
	/** INIT GAME TABLE */
	initGameTable();
	
	/** ONCLICK CONFIG */
	let allCells = document.getElementsByClassName('cell');
	for(let index = 0; index < allCells.length; index++) {
		
		let currentCell = allCells[index];
		currentCell.onclick = function() {
			
			cellClickHandler(currentCell);
		}
	}
}


function initGameTable() {
	
	let allCells = document.getElementsByClassName('cell');
	
	let treasureIndex = 0;
	let skull1Index = 0;
	let skull2Index = 0;
	
	do {
		
		treasureIndex = Math.floor( Math.random() * 24 );
		skull1Index = Math.floor( Math.random() * 24 );;
		skull2Index = Math.floor( Math.random() * 24 );
		
	} while( (treasureIndex == skull1Index) || (treasureIndex == skull2Index) || (skull1Index == skull2Index) );
	

	allCells[treasureIndex].classList.add('treasure');
	allCells[skull1Index].classList.add('skull');
	allCells[skull2Index].classList.add('skull');	
}



function cellClickHandler(clickedCell) {
	
	if(win == 0) {

		clickCounter++;
		let clickCntrBox = document.getElementById('clickCntrBoxId');
		clickCntrBox.innerHTML = 'Steps: ' + clickCounter;
	
	
		if(clickedCell.classList.contains('treasure')) {
			
			clickedCell.classList.add('treasurePicture');
			setTimeout(sendEndGameRequest, 5000);
			win = 1;
		}
		else if(clickedCell.classList.contains('skull')) {
			
			clickedCell.classList.add('skullPicture');
			lifes--;
			if(lifes <= 0) {
				
				setTimeout(sendEndGameRequest, 5000);
				win = 2;
			}
			
			let lifesBox = document.getElementById('lifesBoxId');
			lifesBox.innerHTML = 'Lifes: ' + lifes;
		}
		else {
			
			clickedCell.classList.add('emptyPicture');
		}
	}
}


function sendEndGameRequest() {
	
	let formWinInputElement = document.getElementById('formWinId');
	let formStepsInputElement = document.getElementById('formStepsId');
	
	formWinInputElement.value = win;
	formStepsInputElement.value = clickCounter;
	
	
	let formSubmitButtonElement = document.getElementById('formSubmitButtonId');
	formSubmitButtonElement.click();
}























