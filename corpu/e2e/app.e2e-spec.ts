import { CorpuPage } from './app.po';

describe('corpu App', function() {
  let page: CorpuPage;

  beforeEach(() => {
    page = new CorpuPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
