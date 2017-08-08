let TAGNAMES = {
    'select':'input',
    'change':'input',
    'submit':'form',
    'reset':'form',
    'error':'img',
    'load':'img',
    'abort':'img'
}

let eventSupport = (eventName) => {
    //to support compilation in server-side
    if (typeof window === "undefined" || typeof document === "undefined")
        return false
    let el = document.createElement(TAGNAMES[eventName] || 'div')
    eventName = 'on' + eventName
    let isSupported = (eventName in el)
    if (!isSupported) {
        el.setAttribute(eventName, 'return;')
        isSupported = typeof el[eventName] == 'function'
    }
    el = null
    return isSupported
}

export default eventSupport