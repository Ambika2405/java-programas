const panels = document.querySelectorAll('.panel');

let current = 0;

panels.forEach((panel, index) => {
  panel.addEventListener('click', () => {
    removeActive();
    panel.classList.add('active');
    current = index;
  });
});

function removeActive() {
  panels.forEach(p => p.classList.remove('active'));
}

/* Auto slide */
setInterval(() => {
  panels[current].classList.remove('active');
  current = (current + 1) % panels.length;
  panels[current].classList.add('active');
}, 4000);