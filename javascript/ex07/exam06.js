// 기존 jQuery에 기능(매서드) 추가

ElementBox.prototype.button = function() {
  this.el.forEach((e) => {
    e.classList.add("btn")
  });
};