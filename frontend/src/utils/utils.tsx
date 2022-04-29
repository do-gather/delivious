
//yyyy.mm.dd 포맷 날짜 생성
function getYmd10() {

    var d = new Date();

    return d.getFullYear() + "." + ((d.getMonth() + 1) > 9 ? (d.getMonth() + 1).toString() : "0" + (d.getMonth() + 1)) + "." + (d.getDate() > 9 ? d.getDate().toString() : "0" + d.getDate().toString());
}

export default getYmd10;
