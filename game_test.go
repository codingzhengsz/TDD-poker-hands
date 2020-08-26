package poker_hands_go

import "testing"

func TestRun(t *testing.T) {
	type args struct {
		black string
		white string
	}
	testCases := []struct {
		name string
		args args
		want string
	}{
		{
			"should",
			args{"3H 3D 3S 5C 3D", "3H 3D 3S 5C 3D"},
			"Black win. - with Straight flush",
		},
	}
	for _, tc := range testCases {
		t.Run(tc.name, func(t *testing.T) {
			if got := RunGame(tc.args.black, tc.args.white); got != tc.want {
				t.Errorf("Run(%v, %v) = %v, want %v", tc.args.black, tc.args.white, got, tc.want)
			}
		})
	}
}
