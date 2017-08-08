import React from 'react';
import { render, unmountComponentAtNode } from 'react-dom';

const wrapperId = `toast-${Math.random().toString(16).substring(2)}`;
const defaultTimeout = 2000;
const defaultStyle = {
  container: {
    position: 'fixed',
    top: '60%',
    width: '100%',
    textAlign: 'center',
  },
  text: {
    display: 'inline-block',
    margin: '0 3%',
    padding: '3%',
    fontSize: '14px',
    lineHeight: 'normal',
    textAlign: 'left',
    wordBreak: 'break-all',
    color: '#fff',
    background: '#000',
    borderRadius: '3px',
  },
};

function createWrapper() {
  const wrapper = document.createElement('div');
  wrapper.setAttribute('id', wrapperId);
  document.body.appendChild(wrapper);
}

function element(text, style) {
  return (
    <div style={style.container}>
      <span style={style.text}>{text}</span>
    </div>
  );
}

function mount(text, style) {
  render(element(text, style), document.getElementById(wrapperId));
}

function unmount() {
  unmountComponentAtNode(document.getElementById(wrapperId));
}

function show(text, timeout = defaultTimeout, style = defaultStyle) {
  if (typeof text !== 'string') throw new Error('Toast text must be string.');
  if (typeof timeout !== 'number') throw new Error('Toast timeout must be number.');
  if (typeof style !== 'object') throw new Error('Toast style must be object.');
  if (!document.getElementById(wrapperId)) createWrapper();
  if (!document.getElementById(wrapperId).hasChildNodes()) {
    mount(text, style);
    setTimeout(() => unmount(), timeout);
  }
}

export const toast = { show };
