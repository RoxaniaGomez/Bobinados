//grab open button
const myBtn = document.querySelector('#myBtn');
//grab close button
const closeBtn = document.querySelector('.modal_close');
//grab modal
const modal = document.querySelector('.modal');

//toggle modal 
function toggleModal(){
    if (modal.style.display === 'block') {
        modal.style.display = 'none';
    } else {
        modal.style.display = 'block';
    }    
}

//listner for buttons
myBtn.addEventListener('click', toggleModal);
closeBtn.addEventListener('click', toggleModal);

