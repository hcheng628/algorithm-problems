class Solution:
    def reformatDate(self, date: str) -> str:
        dict = {
            "1st": "01",
            "2nd": "02",
            "3rd": "03",
            "4th": "04",
            "5th": "05",
            "6th": "06",
            "7th": "07",
            "8th": "08",
            "9th": "09",
            "10th": "10",
            "11th": "11",
            "12th": "12",
            "13th": "13",
            "14th": "14",
            "15th": "15",
            "16th": "16",
            "17th": "17",
            "18th": "18",
            "19th": "19",
            "20th": "20",
            "21st": "21",
            "22nd": "22",
            "23rd": "23",
            "24th": "24",
            "25th": "25",
            "26th": "26",
            "27th": "27",
            "28th": "28",
            "29th": "29",
            "30th": "30",
            "31st": "31",
            "Jan": "01",
            "Feb": "02",
            "Mar": "03",
            "Apr": "04",
            "May": "05",
            "Jun": "06",
            "Jul": "07",
            "Aug": "08",
            "Sep": "09",
            "Oct": "10",
            "Nov": "11",
            "Dec": "12"
        }
        arr = date.split()

        return  '-'.join([arr[2], dict[arr[1]], dict[arr[0]]])

    def reformatDate2(self, date: str) -> str:
        M = {
            "Jan": "01",
            "Feb": "02",
            "Mar": "03",
            "Apr": "04",
            "May": "05",
            "Jun": "06",
            "Jul": "07",
            "Aug": "08",
            "Sep": "09",
            "Oct": "10",
            "Nov": "11",
            "Dec": "12"
        }

        day, mon, year = date.split()
        return '-'.join([year, M[mon], ("0" + day[0] if len(day) != 4 else day[0:2])])
