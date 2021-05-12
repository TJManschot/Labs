window.onload = function currentDate() {
    document.querySelector('#copyright-year').innerText = new Date().getFullYear()
}

function addTrip() {
    let template = document.querySelector('#trip-template').content
    let clone = document.importNode(template, true)

    clone.querySelector('.jaar').innerText = '2030'
    clone.querySelector('.stad').innerText = 'Parijs'
    clone.querySelector('.omschrijving').innerText = 'Hier ga ik ooit nog eens naartoe.'

    document.querySelector('#trips').appendChild(clone)
}